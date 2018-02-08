class CreatePatientsPhysicians < ActiveRecord::Migration[5.1]
  def change
    create_table :patients_physicians do |t|
      t.references :patient, foreign_key: true
      t.references :physician, foreign_key: true

      t.timestamps
    end
  end
end
