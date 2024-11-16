package com.cdc.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cdc.entity.Doctor;
import com.cdc.service.IDoctorService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorService doctorService;

	@Override
	public void run(String... args) throws Exception {

		/*		try {
					Doctor doctor = new Doctor();
					doctor.setDocName("Kumar");
					doctor.setDocIncome(9900.00);
					doctor.setDocSpecialization("Entemology");
					String resultMsg = doctorService.registerDoctor(doctor);
					System.out.println(resultMsg);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
		/*try {
			Doctor doc1 = new Doctor();
			doc1.setDocName("Meda");
			doc1.setDocIncome(100000.00);
			doc1.setDocSpecialization("Hemotology");
			Doctor doc2 = new Doctor();
			doc2.setDocIncome(20000.00);
			doc2.setDocName("Rajesh");
			doc2.setDocSpecialization("Neurology");
			Doctor doc3 = new Doctor();
			doc3.setDocIncome(30000.00);
			doc3.setDocName("antony");
			doc3.setDocSpecialization("RMP");
			String msg = doctorService.registerGroupOfDoctors(List.of(doc1, doc2, doc3));
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*try {
			boolean flag = doctorService.isCustomerAvailable(1);
			if (flag) {
				System.out.println("Doctor Available with Given ID  Number");
			} else {
				System.out.println("Doctor Not available");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*try {
			System.out.println("Count of Records " + doctorService.fetchDoctorsCount());
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*try {
			Iterable<Doctor> it = doctorService.showAllDoctors();
			it.forEach(doc -> System.out.println(doc));
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*try {
			doctorService.showAllDoctorsByIds(List.of(1, 2)).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		try {
			Doctor doctor = doctorService.showDoctorById(1);
			System.out.println(doctor);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
