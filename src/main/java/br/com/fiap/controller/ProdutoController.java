package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.model.ProdutoModel;
import br.com.fiap.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	ProdutoRepository repository = ProdutoRepository.getInstance();

	@RequestMapping(value = "/produto", method = RequestMethod.GET)
	public String findAll(Model model) {

		model.addAttribute("produtos", repository.findAll());
		return "produtos";
	}
	
	@RequestMapping(value = "/produto/delete", method = RequestMethod.GET)
	public String findAllDelete(Model model) {

		model.addAttribute("produtos", repository.findAll());
		return "produto-delete-sucesso";
	}

	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable("id") long id, Model model) {

		model.addAttribute("produto", repository.findById(id));
		return "produto-detalhe";
	}

	@RequestMapping(value = "/produto/new", method = RequestMethod.GET)
	public String openSave() {
		return "produto-novo";
	}

	@RequestMapping(value = "/produto/new", method = RequestMethod.POST)
	public String save(ProdutoModel produtoModel, RedirectAttributes redirectAttributes) {

		repository.save(produtoModel);
		redirectAttributes.addFlashAttribute("save", "Produto cadastro com sucesso!");
		return "redirect:/produto";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String openUpdate(@PathVariable("id") long id, Model model) {

		model.addAttribute("produto", repository.findById(id));
		return "produto-editar";
	}

	@RequestMapping(value = "/produto/update", method = RequestMethod.POST)
	public String update(Model model, ProdutoModel produtoModel, RedirectAttributes redirectAttributes) {
		repository.update(produtoModel);
		redirectAttributes.addFlashAttribute("update", "Produto editado com sucesso!");
		return "redirect:/produto";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") long id, Model model, RedirectAttributes redirectAttributes) {
		repository.delete(id);
		redirectAttributes.addFlashAttribute("delete", "Produto deletado com sucesso!");
		return "redirect:/produto";
	}

}
