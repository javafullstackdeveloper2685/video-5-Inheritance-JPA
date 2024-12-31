package Entities;

import javax.persistence.*;

@Entity
//@Table(name = "warrior")
@DiscriminatorValue("WARRIOR")
public class WarriorEntity extends PlayerEntity{

}
