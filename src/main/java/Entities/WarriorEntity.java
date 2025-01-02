package Entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
//@Table(name = "warrior")
@DiscriminatorValue("WARRIOR")
public class WarriorEntity extends PlayerEntity{

}
