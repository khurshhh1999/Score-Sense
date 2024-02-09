package backendSS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MatchDataParser {
	public static List<Match> parseMatchData(String json) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		List<Match> matches = new ArrayList<>();

		try {
			JsonNode rootNode = mapper.readTree(json);
			JsonNode matchesNode = rootNode.path("matches");
			for (JsonNode matchNode : matchesNode) {
				Match match = mapper.treeToValue(matchNode, Match.class);
				String utcDate = matchNode.path("utcDate").asText();
				match.setDate(utcDate);
				String homeTeamName = matchNode.path("homeTeam").path("name").asText();
				match.setTeamHome(homeTeamName);
				String count = matchNode.path("count").asText();
				match.setCount(count);
				String awayTeamName = matchNode.path("awayTeam").path("name").asText();
				match.setTeamAway(awayTeamName);

				List<Goal> goals = new ArrayList<>();
				JsonNode goalsNode = matchNode.path("goals");
				for (JsonNode goalNode : goalsNode) {
					Goal goal = new Goal();
					goal.setMinute(goalNode.path("minute").asInt());
					goal.setScorerName(goalNode.path("scorer").path("name").asText());
					// goal.setAssistName(goalNode.path("assist").path("name").asText());
					goal.setTeamName(goalNode.path("team").path("name").asText());
					goals.add(goal);
				}
				match.setGoals(goals);
				List<Booking> bookings = new ArrayList<>();
				JsonNode bookingsNode = matchNode.path("bookings");
				for (JsonNode bookingNode : bookingsNode) {
					Booking booking = new Booking();
					booking.setMinute(bookingNode.path("minute").asInt());
					booking.setPlayerName(bookingNode.path("player").path("name").asText());
					booking.setCardType(bookingNode.path("card").asText());
					booking.setTeamName(bookingNode.path("team").path("name").asText());
					bookings.add(booking);
				}
				match.setBookings(bookings);
				String status = matchNode.path("status").asText();
				match.setStatus(status);
				matches.add(match);
			}
		} catch (IOException e) {
			e.printStackTrace();
			Throwable rootCause = e.getCause();
			if (rootCause != null) {
				System.out.println("Root cause of IOException: " + rootCause.getMessage());
			} else {
				System.out.println("No specific root cause for the IOException.");
			}
		}

		return matches;
	}

	public static void main(String args[]) {
		System.out.println("Parsed match: ");
	}
}