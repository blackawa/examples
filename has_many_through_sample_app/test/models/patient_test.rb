require 'test_helper'

class PatientTest < ActiveSupport::TestCase
  def setup
    @physician = Physician.create(name: 'physician')
    @patient = Patient.create(name: 'patient', physicians: [@physician])
  end

  test '医者が紐付いていても削除できる' do
    assert_difference 'Patient.count', -1 do
      @patient.destroy
    end
  end

  test '医者が紐付いた状態で削除しても、医者は削除されない' do
    @patient.destroy
    assert_equal 1, Physician.where(name: 'physician').count
  end

  test '医者が紐付いた状態で削除すると、交差テーブルのレコードは消える' do
    @patient.destroy
    assert_equal 0, Physician.find_by(name: 'physician').patients_physicians.count
  end
end
