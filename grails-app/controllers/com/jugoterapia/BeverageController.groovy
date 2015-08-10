package com.jugoterapia

class BeverageController {

  BeverageService beverageService

  def index(){
    render "ok"
  }

  def categories(){
    def categories =  beverageService.getCategories()

    def list = []

    categories.each{
      def item = new Item()
      item.id = it.id
      item.name = it.name
      list << item
    }

    render(contentType:"application/json") {
      list
    }

  }

  def beverages(Integer categoryId){
    def beverages = beverageService.getBeverages(categoryId)

    def list = []

    beverages.each{
      def drink = new Drink()
      drink.id = it.id
      drink.name = it.name
      drink.ingredients = it.ingredients
      drink.recipe = it.recipe
      list << drink
    }

    render(contentType:"application/json") {
      list
    }

  }

  def beverage(Integer beverageId){
    def beverage = beverageService.getBeverage(beverageId)

    def drink = new Drink()
    drink.id = beverage.id
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
  Integer id
  String name
  String ingredients
  String recipe
}

