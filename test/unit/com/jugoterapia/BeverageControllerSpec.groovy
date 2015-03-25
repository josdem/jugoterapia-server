package com.jugoterapia

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(BeverageController)
class BeverageControllerSpec extends Specification {
  
  BeverageService beverageService = Mock(BeverageService)

  def setup() {
     controller.beverageService = beverageService
  }

  void "should render index"() {
    when:
    controller.index()

    then:
    response.text == "ok"
  }

  void "should get categories"() {
    when:
    def result = controller.getCategories()

    then:
    1 * beverageService.getCategories()
  }

}
