package book.hibernate;

import java.util.List;

import book.entities.Section;

public interface SectionHibInterface{
	
	/**
	 * 
	 * @param id id of the desired section
	 * @return The sections specified by the id
	 */
	public Section getSection(Integer id);
	/**
	 * 
	 * @return A list of all the sections 
	 */
	public List<Section> getAllSections();
	
}



