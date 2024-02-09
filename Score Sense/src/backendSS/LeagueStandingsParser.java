package backendSS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LeagueStandingsParser {

	public static List<LeagueStandings> parseLeagueStandingsData(String json, String leagueId) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		List<LeagueStandings> leagueStandings = new ArrayList<>();

		try {
			JsonNode rootNode = mapper.readTree(json);
			JsonNode standingsNode = rootNode.path("standings").get(0).path("table");

			int numberOfTeams = standingsNode.size();

			// Adjust the number of teams based on league ID
			if ("2015".equals(leagueId) || "2002".equals(leagueId)) {
				numberOfTeams = 18;
			}

			for (int i = 0; i < numberOfTeams; i++) {
				JsonNode standingNode = standingsNode.get(i);
				LeagueStandings standings = new LeagueStandings();

				// Set team name
				String fieldName = "setTeam" + (i + 1) + "Name";
				standings.getClass().getMethod(fieldName, String.class).invoke(standings,
						standingNode.path("team").path("name").asText());

				leagueStandings.add(standings);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return leagueStandings;
	}

	public static void main(String args[]) {
		System.out.println("Parsed standings: ");
	}
}