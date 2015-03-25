package com.jugoterapia

class Category {
  String name 
  List<Beverage> beverages

  static constraints = {
    name blank:false,size:1..50
  }

  static mapping = {
    version false
  }
 
  static hasMany = [beverages : Beverage]
}
