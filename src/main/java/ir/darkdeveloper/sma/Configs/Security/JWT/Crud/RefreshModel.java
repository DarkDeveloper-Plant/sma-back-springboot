package ir.darkdeveloper.sma.Configs.Security.JWT.Crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tokens")
public class RefreshModel {

    
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String accessToken;
    private String refreshToken;
    
}
