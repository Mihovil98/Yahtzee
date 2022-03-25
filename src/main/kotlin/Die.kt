class Die {
    private var number = 0
    private var locked = false

    fun getNumber(): Int{
        return number
    }

    fun isLocked(): Boolean{
        return locked
    }

    fun lock() {
        this.locked = true
    }

    fun roll(){
        number = (1..6).random()
    }

    fun restore(){
        this.number = 0
        this.locked = false
    }
}