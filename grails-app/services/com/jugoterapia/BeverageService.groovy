package com.jugoterapia

import grails.transaction.Transactional

@Transactional
class BeverageService {
  
  def getCategories(){
    Category.list()
  }

  def getBeverages(Integer categoryId){
    def category = Category.get(categoryId)
    Beverage.findByCategory(category)
  }
}
