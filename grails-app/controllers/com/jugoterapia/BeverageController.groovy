package com.jugoterapia

class BeverageController {

  def index(){
    render "ok"
  }  

  def getCategories(){
    render(contentType:"application/json") {
        Category.list()
    }
  }

}
