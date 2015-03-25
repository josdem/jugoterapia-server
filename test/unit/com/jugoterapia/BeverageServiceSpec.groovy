package com.jugoterapia

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BeverageService)
@Mock(Category)
class BeverageServiceSpec extends Specification {

  void "should list categories"() {
    when:
    service.getCategories()
    then:
    Category.list() >> true
  }

}
