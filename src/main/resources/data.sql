INSERT INTO shelter (name, city, address) VALUES
                                              ('Shelter Uno', 'Potenza', 'Via Roma 1'),
                                              ('Shelter Due', 'Napoli', 'Via Garibaldi 2');

-- Inserisci gli animali collegando il shelter_id (l'ID del rifugio) già generato
INSERT INTO pet (name, species, age, is_adopted, is_vaccinated, shelter_id) VALUES
                                                                                ('Simba', 'Cat', 3, false, true, 1),
                                                                                ('Luna', 'Dog', 2, false, true, 2),
                                                                                ('Toby', 'Cat', 3, false, false, 1);

-- Inserisci le richieste di adozione, collegando pet_id (l'ID dell'animale) e user_id (l'ID dell'utente)
INSERT INTO adoption_request (adopter_name, adopter_contract, pet_id, user_id, request_date, is_approved) VALUES
                                                                                                              ('John Doe', 'ABC123', 1, 1, '2024-12-03', true),
                                                                                                              ('Jane Smith', 'XYZ456', 2, 2, '2024-12-03', false);