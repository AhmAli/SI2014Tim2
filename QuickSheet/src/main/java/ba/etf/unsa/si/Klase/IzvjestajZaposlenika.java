package ba.etf.unsa.si.Klase;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

import javax.naming.directory.InvalidAttributeValueException;

public class IzvjestajZaposlenika extends Izvjestaj{

	private Zaposlenik zaposlenik;
	
	public IzvjestajZaposlenika(Projekat _projekat, Zaposlenik _zaposlenik) throws InvalidAttributeValueException {
		super(_projekat);
		setZaposlenik(_zaposlenik);
	}

	public Zaposlenik getZaposlenik() 
	{
		return zaposlenik;
	}
	
	public void setZaposlenik(Zaposlenik zaposlenik) throws InvalidAttributeValueException 
	{
		if (zaposlenik != null && projekat.getZaposlenici().contains(zaposlenik))
		{
			this.zaposlenik = zaposlenik;
			IzracunajProcenatZavrsenogRada();
			IzracunajTrosak();
		}
		else throw new InvalidAttributeValueException();
	}
	
	@Override
	public void setProjekat(Projekat projekat) throws InvalidAttributeValueException 
	{
		if (projekat != null && projekat.getZaposlenici().contains(zaposlenik))
		{
			this.projekat = projekat;
			IzracunajProcenatZavrsenogRada();
			IzracunajTrosak();
		}
		else throw new InvalidAttributeValueException();
	}

	@Override
	public void IzracunajProcenatZavrsenogRada() {
		LinkedList<Task> taskovi = projekat.getTaskovi();
		Hashtable<String, Double> taskoviZaposlenik = new Hashtable<String, Double>();
		int ukupnoTaskova = 0;
		for (Task ta: taskovi)
		{
			if (ta.getZaposlenik().equals(zaposlenik))
				ukupnoTaskova++;
		}
		for (Timesheet t : projekat.getTimesheetList())
		{
			if (t.getTaskovi().get(0).getZaposlenik().equals(zaposlenik) && t.getValidiran())
			{
				for (Task task: t.getTaskovi())
				{
					taskoviZaposlenik.put(task.getNaziv(), task.getProcenatZavrsenosti());
				}
			}
		}
		Set<String> keys = taskoviZaposlenik.keySet();
		procenatZavrsenogRada = 0.0;
		for (String key: keys)
		{
			procenatZavrsenogRada += taskoviZaposlenik.get(key);
		}
		procenatZavrsenogRada /= ukupnoTaskova;
	}

	@Override
	public void IzracunajTrosak() {
		IzracunajUkupnoVrijemeRada();		
		trosak = zaposlenik.getSatnica() * ukupnoVrijemeRada;
	}

	@Override
	public void IzracunajUkupnoVrijemeRada() {
		ukupnoVrijemeRada = 0.0;
		for (Timesheet t : projekat.getTimesheetList())
		{
			if (t.getTaskovi().get(0).getZaposlenik().equals(zaposlenik) && t.getValidiran() && t.getProjekat().equals(projekat))
			{
				ukupnoVrijemeRada += t.getBrojRadnihSati(); 
			}
		}
	}

}
