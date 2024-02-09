package backendSS;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class FootballDataAPI {
	private static final String API_KEY = "7e221e7f6921446da43cdf80e42f936d";
	private final static HttpClient httpClient = HttpClient.newHttpClient();

	public static String request(String endpoint) throws IOException, InterruptedException {
		URI uri = URI.create("https://api.football-data.org/v4/" + endpoint);

		HttpRequest request = HttpRequest.newBuilder().uri(uri).header("X-Auth-Token", API_KEY).build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		if (response.statusCode() == 200) {
			return response.body();
		} else {
			throw new IOException("HTTP request failed with status code: " + response.statusCode());
		}
	}

	public static String getMatchesForTeamOrLeague(String teamId, String leagueId) throws InterruptedException {
		// try {
		// String endpoint = "matches";
		// if (teamId != null) { , String leagueId
		// endpoint += "?team=" + teamId;
		// } else if (leagueId != null) {
		// endpoint += "?competition=" + leagueId;
		// }
		// return request(endpoint);
		// } catch (IOException e) {
		// e.printStackTrace();
		// return "{\"error\": \"Unable to retrieve matche for team ID: " + teamId + "
		// and league: " + leagueId + "\"}";

		// }
		try {
			// String endpoint = "competition/"+leagueId+"/teams/" + teamId +
			// "/matches?status=SCHEDULED";
			String endpoint = "teams/" + teamId + "/matches?status=SCHEDULED";
			return request(endpoint);

		} catch (IOException e) {
			e.printStackTrace();
			return "{\"error\": \"Unable to retrieve scheduled matches for team ID: " + teamId + "\"}";
		}
	}

	public static String getMatchesForLeague(String leagueId, int matchday) throws InterruptedException {
		try {
			String endpoint = "competitions/" + leagueId + "/matches";
			if (matchday > 0) {
				endpoint += "?matchday=" + matchday;
			}
			return request(endpoint);
		} catch (IOException e) {
			e.printStackTrace();
			return "{\"error\": \"Unable to retrieve league matches for league ID: " + leagueId + " and matchday: "
					+ matchday + "\"}";

		}
	}

	public static String getLeagueStandingsForLeague(String leagueId) throws InterruptedException {
		try {
			String endpoint = "competitions/" + leagueId + "/standings";
			return request(endpoint);
		} catch (IOException e) {
			e.printStackTrace();
			return "{\"error\": \"Unable to retrieve league matches for league ID: " + leagueId + "}";
		}
	}

	public static String getLiveMatchesForTeam(String teamId) throws InterruptedException {
		try {
			String endpoint = "teams/" + teamId + "/matches?status=LIVE";
			return request(endpoint);
		} catch (IOException e) {
			// System.err.println("Exception occurred while getting live matches for team
			// ID: " + teamId);
			e.printStackTrace();
			return "{\"error\": \"Unable to retrieve live matches for team ID: " + teamId + "\"}";

		}
	}
}
