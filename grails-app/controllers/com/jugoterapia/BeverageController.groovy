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
    beverageService.getBeverages(categoryId) 
  }

}

class Item {
  Integer id
  String name
}

