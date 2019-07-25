package technight.domaines

class Company {
    
    String name

    static hasMany = [computers : Computer]

    static constraints = {
        name( nullable:false, minSize:2, maxSize:50, unique: true)
    }

    toString(){
        return name
    }
}
