package Entities;

import javax.persistence.*;

@Entity
//@Table(name = "mage")
@DiscriminatorValue("MAGE")
public class MageEntity extends PlayerEntity {

}
