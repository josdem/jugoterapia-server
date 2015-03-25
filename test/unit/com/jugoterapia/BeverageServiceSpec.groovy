package com.jugoterapia

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BeverageService)
@Mock([Category,Beverage])
class BeverageServiceSpec extends Specification {

  void "should list categories"() {
    when:
    service.getCategories()

    then:
    Category.list() >> true
  }

  void "should get beverages by category"(){
    given:
    def categoryId = 1    
    Category mockCategory = Mock()

    when:
    service.getBeverages(categoryId)

    then:
    Category.get(categoryId) >> mockCategory
    Beverage.findByCategory(mockCategory) >> true   
  }

}
