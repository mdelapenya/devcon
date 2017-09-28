package io.wedeploy.example;

import com.wedeploy.api.ApiClient;
import com.wedeploy.api.WeDeploy;
import com.wedeploy.api.sdk.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class WeDeployController {

    static {
        ApiClient.init();
    }

    private final String dbUrl;

    public WeDeployController() {
        dbUrl = "https://db-devcon.wedeploy.io";
    }

    public static void main(String[] args) {
        SpringApplication.run(WeDeployController.class, args);
    }

    @RequestMapping("/")
    public ModelAndView hello() {
        return new ModelAndView("layout");
    }

    @RequestMapping("/voteForCats")
    public ModelAndView voteForCats() {
        Map<String, Object> votes = fetchVotes();

        Integer catsVotes = (Integer) votes.get("cats");

        if (catsVotes == null) {
            catsVotes = 1;
        }
        else {
            catsVotes = catsVotes + 1;
        }

        votes.put("cats", catsVotes);

        saveVotes(votes);

        return new ModelAndView("layout");
    }

    @RequestMapping("/voteForDogs")
    public ModelAndView voteForDogs() {
        Map<String, Object> votes = fetchVotes();

        Integer dogsVotes = (Integer) votes.get("dogs");

        if (dogsVotes == null) {
            dogsVotes = 1;
        }
        else {
            dogsVotes = dogsVotes + 1;
        }

        votes.put("dogs", dogsVotes);

        saveVotes(votes);

        return new ModelAndView("layout");
    }

    @GetMapping(path = "/votes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map votes() {
    	return fetchVotes();
    }

    /**
     * Saves the vote to the datastore.
     */
    private void saveVotes(Map<String, Object> votes) {
        Response response = WeDeploy
            .url(dbUrl)
            .path("/devcon/votes")
            .put(votes);

        if (!response.succeeded()) {
        	throw new RuntimeException(
        		"Saving votes failed: " + response.statusCode() + " " + response.statusMessage());
        }
    }

    /**
     * Fetch votes from the datastore.
     */
    @SuppressWarnings("unchecked")
    private Map<String, Object> fetchVotes() {
        Response response = WeDeploy
            .url(dbUrl)
            .path("/devcon/votes")
            .get();

        if (response.statusCode() == 404) {
            return new HashMap<>();
        }

        if (!response.succeeded()) {
	        throw new RuntimeException(
		        "Fetching votes failed: " + response.statusCode() + " " + response.statusMessage());
        }

        Map<String, Object> votes =
            response.bodyMap(String.class, Object.class);

        if (votes == null) {
            votes = new HashMap<>();
        }

        return votes;
    }

}