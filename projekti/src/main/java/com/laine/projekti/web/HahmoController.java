package com.laine.projekti.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laine.projekti.domain.Hahmo;
import com.laine.projekti.domain.HahmoRepository;

@Controller
public class HahmoController {
	
	@Autowired
	private HahmoRepository repository;
	
	private List<Hahmo> hahmot = new ArrayList();
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/hahmolista")
	public String hahmoLista(Model model) {
		model.addAttribute("hahmot", repository.findAll());
		return "hahmoLista";
	}
	
	 @RequestMapping(value="/hahmot", method = RequestMethod.GET)
	 public @ResponseBody List<Hahmo> hahmoListRest() {
		 return (List<Hahmo>) repository.findAll();
	 }
	 
	 @RequestMapping(value="/hahmo/{id}", method = RequestMethod.GET)
	 public @ResponseBody Hahmo findHahmoRest(@PathVariable("id") Long hahmoId) {
		 return repository.findOne(hahmoId);
	 }
	 
	 @RequestMapping(value = "/add")
	 public String addHahmo(Model model){
		 model.addAttribute("hahmo", new Hahmo());
		 return "addhahmo";
	 }
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	 public String save(Hahmo hahmo){
		 repository.save(hahmo);
		 return "redirect:hahmolista";
	 }
	 
		@RequestMapping(method = RequestMethod.PUT)
		public Hahmo updateHahmo(@RequestBody Hahmo hahmo) {
			Hahmo modifiedHahmo = this.hahmot.stream().filter(u -> u.getId() == hahmo.getId()).findFirst().orElse(null);
			modifiedHahmo.setNimi(hahmo.getNimi());
			modifiedHahmo.setIka(hahmo.getIka());
			modifiedHahmo.setKoodi(hahmo.getKoodi());
			modifiedHahmo.setElain(hahmo.getElain());
			return modifiedHahmo;
		}
	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	 public String deleteHahmo(@PathVariable("id") Long hahmoId, Model model) {
		 repository.delete(hahmoId);
		 return "redirect:../hahmolista";
	 }

}
