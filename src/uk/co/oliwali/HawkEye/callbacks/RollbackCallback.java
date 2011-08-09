package uk.co.oliwali.HawkEye.callbacks;

import org.bukkit.command.CommandSender;

import uk.co.oliwali.HawkEye.PlayerSession;
import uk.co.oliwali.HawkEye.Rollback;
import uk.co.oliwali.HawkEye.database.SearchQuery.SearchError;
import uk.co.oliwali.HawkEye.util.Util;

/**
 * Implementation of BaseCallback for use in rollback commands
 * @author oliverw92
 */
public class RollbackCallback extends BaseCallback {
	
	private PlayerSession session;
	private CommandSender sender;
	
	public RollbackCallback(PlayerSession session) {
		this.session = session;
		sender = session.getSender();
		Util.sendMessage(sender, "&cSearching for matching results to rollback...");
	}

	public void execute() {
		session.setRollbackResults(results);
		new Rollback(session);
	}

	public void error(SearchError error, String message) {
		Util.sendMessage(session.getSender(), message);
	}

}
