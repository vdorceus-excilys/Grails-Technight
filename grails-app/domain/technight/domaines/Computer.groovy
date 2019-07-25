package technight.domaines

import technight.utils.DateValidator

class Computer {

    String name
    Date introduced
    Date discontinued

    static belongsTo = [company : Company]

    static constraints = {
        name ( nullable:false, minSize:2, maxSize:50);
        introduced ( nullable:true, validator: {value, object, errors -> return DateValidator.isIntroducedValid(value,object.discontinued); } );
        discontinued (nullable:true, validator: {value, object, errors -> return DateValidator.isDiscontinuedValid(object.introduced,value); } );
    }

    toString(){
        return name
    }
}
