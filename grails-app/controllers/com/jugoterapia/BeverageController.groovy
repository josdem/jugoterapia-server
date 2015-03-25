package com.jugoterapia

class BeverageController {

  def index(){
    render "ok"
  }  

  def getCategories(){
    def categories =  Category.list()
  
    def json = []

    categories.each{
      def item = new Item()
      item.id = it.id
      item.name = it.name
      json << item
    }

    render(contentType:"application/json") {
      json
    }
  }

}

class Item {
  Integer id
  String name
}

