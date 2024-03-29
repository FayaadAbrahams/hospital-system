package za.ac.cput.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@Table(name = "tbl_doctor")
public class Doctor {
    @Id
    @NotNull
    private String docID;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String cellNum;

    public Doctor(String docID, String firstName, String lastName, String cellNum) {
        this.docID = docID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellNum = cellNum;
    }
}
