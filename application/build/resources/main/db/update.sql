UPDATE companies
SET NAME = :name, SITE = :site, EMAIL = :email, DESCRIPTION = :description, UPDATED_AT = :updatedAt
WHERE id = :id
