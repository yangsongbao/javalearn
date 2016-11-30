var Bike = function() {

    // 只能在这一行下面写代码
    var gear = 5;

    this.getGear = function(){
        return gear;
    };

    this.setGear = function(change){
        gear = change;
    };

};

var myBike = new Bike();

myBike.setGear(4);
console.log(myBike.getGear());
