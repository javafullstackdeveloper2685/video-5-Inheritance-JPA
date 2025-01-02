package Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
//@Table(name = "mage")
@DiscriminatorValue("MAGE")
public class MageEntity extends PlayerEntity {

}
