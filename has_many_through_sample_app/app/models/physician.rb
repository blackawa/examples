class Physician < ApplicationRecord
  has_many :patients_physicians
  has_many :patients, through: :patients_physicians, dependent: :restrict_with_exception
end
