package technight.domaines

class Company {
    
    String name

    static hasMany = [computers : Computer]

    static constraints = {
    }
}
