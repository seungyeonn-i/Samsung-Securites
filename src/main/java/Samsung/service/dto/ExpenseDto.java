package Samsung.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {
    private String title;
    private Long price;
    private Date date;

    public ExpenseDto(String title, Long price, Date date) {
        this.title = title;
        this.price = price;
        this.date = date;
    }

    private String priceStr;
    private String dateStr;

    public void setPriceStr(Long price) {

        DecimalFormat decFormat = new DecimalFormat("###,###");

        this.priceStr = decFormat.format(price);
    }

    public void setDateStr(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        this.dateStr=sdf.format(date);
    }
}
