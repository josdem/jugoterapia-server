package com.jugoterapia

import groovy.json.JsonBuilder

class BeverageController {

  BeverageService beverageService

  def index(){
    render "ok"
  }  

  def categories(){
    def categories =  beverageService.getCategories()
  
    def map = []

    categories.each{
      def item = new Item()
      item.id = it.id
      item.name = it.name
      map << item
    }

    render "{\"categories\":" +  new JsonBuilder( map ) +"}"
  }

  def beverages(Integer categoryId){
    def beverages = beverageService.getBeverages(categoryId) 
    
    def map = []
    
    beverages.each{
      def drink = new Drink()
      drink.name = it.name
      drink.ingredients = it.ingredients
      drink.recipe = it.recipe
      map << drink
    }

    render "{\"beverages\":" +  new JsonBuilder( map ) +"}"
  }

  def beverage(Integer beverageId){
    def beverage = beverageService.getBeverage(beverageId) 

    def drink = new Drink()
    drink.name = beverage.name
    drink.ingredients = beverage.ingredients
    drink.recipe = beverage.recipe
  
    render(contentType:"application/json") {
      drink
    }
 
  }

}

class Item {
  Integer id
  String name
}

class Drink {
  String name
  String ingredients
  String recipe
}

