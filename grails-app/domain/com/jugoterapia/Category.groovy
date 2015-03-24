package com.jugoterapia

class Category {
  String name 

  static constraints = {
    name blank:false,size:1..50
  }
}
