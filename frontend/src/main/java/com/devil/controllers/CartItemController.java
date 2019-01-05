package com.devil.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devil.dao.CartItemDao;
import com.devil.dao.ProductDao;
import com.devil.models.CartItem;
import com.devil.models.Product;
import com.devil.models.User;

@Controller
public class CartItemController {
	@Autowired
	private CartItemDao cartItemDao;
	@Autowired
	private ProductDao productDao;
	public CartItemController() {
		System.out.println("CartItemController bean is Created");
	}
	@RequestMapping(value="/cart/addtocart/{productId}")
	public String addToCart(@RequestParam int requestedQuantity, @PathVariable int productId, @AuthenticationPrincipal Principal principal) {
		String email="";
		if(principal!=null)
	       email = principal.getName();
		Product product = productDao.getProduct(productId);
		email = principal.getName();
		User user = cartItemDao.getUser(email);
		
		CartItem cartItem =new CartItem();
		cartItem.setUser(user);
		cartItem.setProduct(product);
		cartItem.setQuantity(requestedQuantity);
		cartItem.setTotalPrice(requestedQuantity*product.getPrice());
		cartItemDao.addToCart(cartItem);
		return "redirect:/cart/getcartitems";
	}
	@RequestMapping(value="/cart/getcartitems")
	public String getCartItems(@AuthenticationPrincipal Principal principal, Model model) {
		String email="";
		if(principal!=null)
		{
			email = principal.getName();
		}
		List<CartItem> cartItems = cartItemDao.getCartItems(email);
		model.addAttribute("cartItems",cartItems);
		return "cart";
	}
	@RequestMapping(value="/cart/updatecartitem")
	public String updateCartItem(@RequestParam int cartItemId,@RequestParam int requestedQuantity){
		cartItemDao.updateCartItem(cartItemId, requestedQuantity);
		return "redirect:/cart/getcartitems";
	}
	@RequestMapping(value="/cart/removecartitem/{cartItemId}")
	public String removeCartItem(@PathVariable int cartItemId) {
		cartItemDao.removeCartItem(cartItemId);
		return "redirect:/cart/getcartitems";
	}
	@RequestMapping(value="/cart/clearcart")
	public String clearCart(@AuthenticationPrincipal Principal principal) {
		
		List<CartItem> cartItems = cartItemDao.getCartItems(principal.getName());
		for (CartItem cartItem:cartItems)
		{
			cartItemDao.removeCartItem(cartItem.getCartItemId());
		}
		return "redirect:/cart/getcartitems";
		
	}
	
	

}
