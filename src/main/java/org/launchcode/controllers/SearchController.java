package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

  @RequestMapping(value = "")
  public String search(Model model) {
    model.addAttribute("columns", ListController.columnChoices);
    return "search";
  }

  // TODO #1 - Create handler to process search request and display results

  @RequestMapping(value = "results")
  public String searchResults(Model model, @RequestParam String searchTerm, @RequestParam String searchType) {

/*   if (column.equals("all")) {
            ArrayList<HashMap<String, String>> jobs = JobData.findAll();
            model.addAttribute("title", "All Jobs");
            model.addAttribute("jobs", jobs);
            return "list-jobs";
        } else {
            ArrayList<String> items = JobData.findAll(column);
            model.addAttribute("title", "All " + columnChoices.get(column) + " Values");
            model.addAttribute("column", column);
            model.addAttribute("items", items);
            return "list-column";
        }*/

    if (searchType.equalsIgnoreCase("all")) {
      ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
      model.addAttribute("jobs", jobs);
      model.addAttribute("jobssize", Integer.toString(jobs.size())+" Result(s)");

    }
    else{
      ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType,searchTerm);
      model.addAttribute("jobs", jobs);
      model.addAttribute("jobssize", Integer.toString(jobs.size())+" Result(s)");
    }
    model.addAttribute("columns", ListController.columnChoices);

    //String fun="adsf";
    //fun.su
    //String output = input.substring(0, 1).toUpperCase() + input.substring(1);
    return "search";
    //return "redirect:/search";

  }

}
