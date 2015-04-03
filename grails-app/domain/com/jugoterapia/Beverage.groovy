package com.jugoterapia

class Beverage {

  String name
  String ingredients
  String recipe

  static constraints = {
    name blank:false,size:1..100
    ingredients blank:false,size:1..255
    recipe blank:false,size:1..255
  }

  static mapping = {
    version false
    ingredients type:"text"
    recipe type: "text"
  }

  static belongsTo = [category : Category]

}
