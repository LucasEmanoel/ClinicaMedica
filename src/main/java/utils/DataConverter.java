package utils;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter("dataConverter")
public class DataConverter implements Converter {

    private DateTimeConverter converter = new DateTimeConverter();

    public DataConverter() {
        converter.setPattern("dd/MM/yyyy");
        converter.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String dataString) {
        Date data = (Date) converter.getAsObject(context, component, dataString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return calendar;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object dataObject) {
        if(dataObject == null)
            return null;

        Calendar calendar = (Calendar) dataObject;
        return converter.getAsString(context, component, calendar.getTime());
    }

}