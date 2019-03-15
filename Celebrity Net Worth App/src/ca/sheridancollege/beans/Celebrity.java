package ca.sheridancollege.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Celebrity {

		private String firstName;
		private String lastName;
		private String email;
		private double netWorth;
}
