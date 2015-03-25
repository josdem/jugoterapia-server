package com.jugoterapia

class Beverage {

  String name
  String ingredients
  String recipe

  static constraints = {
    name blank:false,size:1..50
    ingredients blank:false,size:1..255
    recipe blank:false,size:1..255
  }

  static mapping = {
    version false
  }

  static belongsTo = [category : Category]

}
