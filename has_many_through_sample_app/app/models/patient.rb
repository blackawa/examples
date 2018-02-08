class Patient < ApplicationRecord
  has_many :patients_physicians, dependent: :destroy
  has_many :physicians, through: :patients_physicians, dependent: :nullify
end
