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

  def setup() {
    controller.beverageService = beverageService
    def item = new Categoria()
    item.id = 1
    item.name = "Curativos"
    item.clazz = "com.jugoterapia.Category"
    categories << item
  }

  void "should render index"() {
    when:
    controller.index()

    then:
    response.text == "ok"
  }

  void "should get categories"() {
    when:
    controller.getCategories()

    then:
    1 * beverageService.getCategories() >> categories
    response.text == "[{\"id\":1,\"name\":\"Curativos\"}]"
  }

}

class Categoria {
  Integer id
  String name
  String clazz
}
