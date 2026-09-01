// Mock data for M1 - replace with API calls in later phases

export const dealerRentals = [
  {
    id: 1,
    equipmentName: 'CAT 320 Excavator',
    customerId: 'CUST-001',
    rentalStart: '2026-09-01',
    rentalEnd: '2026-09-15',
    status: 'active',
    dailyRate: 350,
  },
  {
    id: 2,
    equipmentName: 'CAT 950 Wheel Loader',
    customerId: 'CUST-002',
    rentalStart: '2026-08-28',
    rentalEnd: '2026-09-10',
    status: 'active',
    dailyRate: 280,
  },
  {
    id: 3,
    equipmentName: 'CAT D6 Bulldozer',
    customerId: 'CUST-003',
    rentalStart: '2026-09-05',
    rentalEnd: '2026-09-20',
    status: 'scheduled',
    dailyRate: 400,
  },
]

export const dealerMaintenance = [
  {
    id: 1,
    equipmentName: 'CAT 320 Excavator',
    lastServiceDate: '2026-08-15',
    nextServiceDue: '2026-10-15',
    status: 'good',
    maintenanceHours: 2500,
  },
  {
    id: 2,
    equipmentName: 'CAT 950 Wheel Loader',
    lastServiceDate: '2026-07-20',
    nextServiceDue: '2026-09-20',
    status: 'warning',
    maintenanceHours: 3200,
  },
  {
    id: 3,
    equipmentName: 'CAT D6 Bulldozer',
    lastServiceDate: '2026-08-01',
    nextServiceDue: '2026-11-01',
    status: 'good',
    maintenanceHours: 1800,
  },
]

export const topPerformingRigs = [
  {
    id: 1,
    equipmentName: 'CAT 320 Excavator',
    totalRentalDays: 150,
    totalRevenue: 52500,
    utilizationRate: 82,
    avgRating: 4.8,
  },
  {
    id: 2,
    equipmentName: 'CAT 950 Wheel Loader',
    totalRentalDays: 130,
    totalRevenue: 36400,
    utilizationRate: 75,
    avgRating: 4.6,
  },
  {
    id: 3,
    equipmentName: 'CAT D6 Bulldozer',
    totalRentalDays: 95,
    totalRevenue: 38000,
    utilizationRate: 68,
    avgRating: 4.9,
  },
]

export const customerEquipment = [
  {
    id: 1,
    equipmentName: 'CAT 320 Excavator',
    rentalStart: '2026-09-01',
    rentalEnd: '2026-09-15',
    status: 'active',
    daysRemaining: 14,
    costPerDay: 350,
  },
  {
    id: 2,
    equipmentName: 'CAT 950 Wheel Loader',
    rentalStart: '2026-08-28',
    rentalEnd: '2026-09-10',
    status: 'active',
    daysRemaining: 9,
    costPerDay: 280,
  },
]

export const newRigRequest = {
  id: 'NEW-001',
  status: 'pending',
  requestDate: '2026-08-30',
  equipmentType: 'Crane',
  capacity: '50 tons',
  rentalPeriod: '2026-10-01 to 2026-10-15',
  purpose: 'Construction project',
}
