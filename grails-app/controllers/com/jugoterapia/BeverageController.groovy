package com.jugoterapia

class BeverageController {

  def index(){
    render "ok"
  }  

  def getCategories(){
    return ["Curativos","Energizantes","Saludables","Estimulantes"]
  }

}
