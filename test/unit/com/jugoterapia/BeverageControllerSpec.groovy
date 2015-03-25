package com.jugoterapia

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(BeverageController)
@Mock(Category)
class BeverageControllerSpec extends Specification {
  
  void setupSpec() {
    mockDomain(Category)
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
    result == "name"
  }

}
