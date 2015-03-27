package com.jugoterapia

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(BeverageController)
class BeverageControllerSpec extends Specification {
  
  BeverageService beverageService = Mock(BeverageService)
  def categories = []
  def beverages = []

  def item = new GrailsCategory()
  def drink  = new GrailsBeverage()

  def setup() {
    controller.beverageService = beverageService
    item.id = 1
    item.name = "Curativos"
    item.clazz = "com.jugoterapia.Category"
    categories << item

    drink.id = 1
    drink.name = "Jugo para evitar los calambres"
    drink.ingredients = "3 Tallos de apio"
    drink.recipe = "Mezcla 3 tallos de apio procesalos en el extractor de jugos."
    drink.category = item
    beverages << drink
  }

  void "should render index"() {
    when:
    controller.index()

    then:
    response.text == "ok"
  }

  void "should get categories"() {
    when:
    controller.categories()

    then:
    1 * beverageService.getCategories() >> categories
    response.text == "{\"categories\":[{\"id\":1,\"name\":\"Curativos\"}]}"
  }

  void "should get beverages by category"(){
    given:
    def categoryId = 1

    when:
    controller.beverages(categoryId)

    then:
    1 * beverageService.getBeverages(categoryId) >> beverages
    response.text == "{\"beverages\":[{\"ingredients\":\"3 Tallos de apio\",\"id\":1,\"recipe\":\"Mezcla 3 tallos de apio procesalos en el extractor de jugos.\",\"name\":\"Jugo para evitar los calambres\"}]}"
  }

  void "should get beverage by id"(){
    given:
    def beverageId = 1
    
    when:
    controller.beverage(beverageId)

    then:
    1 * beverageService.getBeverage(beverageId) >> drink
    response.text == "{\"id\":1,\"ingredients\":\"3 Tallos de apio\",\"name\":\"Jugo para evitar los calambres\",\"recipe\":\"Mezcla 3 tallos de apio procesalos en el extractor de jugos.\"}"
  }

}

class GrailsCategory {
  Integer id
  String name
  String clazz
}

class GrailsBeverage {
  Integer id
  String name
  String ingredients
  String recipe
  GrailsCategory category
}
