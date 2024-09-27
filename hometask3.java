package SelfAssessment;

abstract class Engine {
    public abstract String getType();
}

class CombustionEngine extends Engine {
    @Override
    public String getType() {
        return "Combustion Engine";
    }
}

class ElectricEngine extends Engine {
    @Override
    public String getType() {
        return "Electric Engine";
    }
}

class HybridEngine extends Engine {
    @Override
    public String getType() {
        return "Hybrid Engine";
    }
}


class Manufacture {
    private String name;
    private String country;

    public Manufacture(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name + " (" + country + ")";
    }
}


abstract class Vehicle {
    protected Manufacture manufacture;
    protected Engine engine;

    public Vehicle(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture;
        this.engine = engine;
    }

    public abstract void ShowCharacteristics();
}

class ICEV extends Vehicle {
    public ICEV(Manufacture manufacture, Engine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("ICEV - Manufacture: " + manufacture + ", Engine: " + engine.getType());
    }
}

class BEV extends Vehicle {
    public BEV(Manufacture manufacture, Engine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("BEV - Manufacture: " + manufacture + ", Engine: " + engine.getType());
    }
}

class HybridV extends Vehicle {
    public HybridV(Manufacture manufacture, Engine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("HybridV - Manufacture: " + manufacture + ", Engine: " + engine.getType());
    }
}

public class VehicleManager {
    public static void main(String[] args) {
        Manufacture toyota = new Manufacture("Toyota", "Japan");
        Manufacture tesla = new Manufacture("Tesla", "USA");
        Manufacture ford = new Manufacture("Ford", "USA");

        Engine combustionEngine = new CombustionEngine();
        Engine electricEngine = new ElectricEngine();
        Engine hybridEngine = new HybridEngine();

        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new ICEV(toyota, combustionEngine);
        vehicles[1] = new BEV(tesla, electricEngine);
        vehicles[2] = new HybridV(ford, hybridEngine);

        for (Vehicle vehicle : vehicles) {
            vehicle.ShowCharacteristics();
        }
    }
}
