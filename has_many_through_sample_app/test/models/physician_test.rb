require 'test_helper'

class PhysicianTest < ActiveSupport::TestCase
  test '患者が一人でもついていると削除できない' do
    patient = Patient.create(name: 'patient1')
    physician = Physician.create(name: 'physician', patients: [patient])

    assert_raise(ActiveRecord::DeleteRestrictionError) { physician.destroy }
  end

  test '患者が一人もいなければ削除できる' do
    physician = Physician.create(name: 'physician')

    assert_difference 'Physician.count', -1 do
      physician.destroy
    end
  end
end
