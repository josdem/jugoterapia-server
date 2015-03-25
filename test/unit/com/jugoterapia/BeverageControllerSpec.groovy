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

  def setup() {
    controller.beverageService = beverageService
    def item = new GrailsCategory()
    item.id = 1
    item.name = "Curativos"
    item.clazz = "com.jugoterapia.Category"
    categories << item

    def drink  = new GrailsBeverage()
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
    response.text == "{\"beverages\":[{\"ingredients\":\"3 Tallos de apio\",\"recipe\":\"Mezcla 3 tallos de apio procesalos en el extractor de jugos.\",\"name\":\"Jugo para evitar los calambres\"}]}"
  }

  void "should get beverage by id"(){
    given:
    def beverageId = 1
    
    when:
    controller.beverage(beverageId)

    then:
    1 * beverageService.getBeverage(beverageId)
  }

}

class GrailsCategory {
  Integer id
  String name
  String clazz
}

class GrailsBeverage {
  String name
  String ingredients
  String recipe
  GrailsCategory category
}
