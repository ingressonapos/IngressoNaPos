package br.usp.ime.ingpos.testes;

import junit.textui.TestRunner;

public class AuditTest
    extends
        IngPosTestCase
{

    // ********************************************************** //

    @org.junit.Test
    public void testAuditLog()
        throws Exception
    {
        //
        // // Save a user without audit logging
        // UserDAO userDAO = new UserDAO();
        // User u1 = new User("Christian", "Bauer", "turin", "abc123",
        // "christian@hibernate.org");
        // userDAO.makePersistent(u1);
        // HibernateUtil.commitTransaction();
        // HibernateUtil.closeSession();
        //
        // // Enable interceptor
        // AuditLogInterceptor interceptor = new AuditLogInterceptor();
        // HibernateUtil.registerInterceptor(interceptor);
        // interceptor.setSession(HibernateUtil.getSession());
        // interceptor.setUserId(u1.getId());
        //
        // // Save an item with audit logging enabled
        // Item item = new Item("ONE", "Foo",
        // u1,
        // new MonetaryAmount(new BigDecimal("1.99"),
        // Currency.getInstance(Locale.US)),
        // new MonetaryAmount(new BigDecimal("50.33"),
        // Currency.getInstance(Locale.US)),
        // new Date(), new Date());
        // ItemDAO itemDAO = new ItemDAO();
        // itemDAO.makePersistent(item);
        //
        // // Synchronize state to trigger interceptor
        // HibernateUtil.getSession().flush();
        //
        // // Check audit log
        // Query queryAuditOne =
        // HibernateUtil.getSession().createQuery("from AuditLogRecord lr where lr.entityId = :id");
        // queryAuditOne.setParameter("id", item.getId());
        // AuditLogRecord logRecordOne =
        // (AuditLogRecord)queryAuditOne.uniqueResult();
        // assertEquals(logRecordOne.userId, u1.getId());
        //
        // HibernateUtil.commitTransaction();
        // HibernateUtil.closeSession();
        //
        // // Deregister interceptor
        // HibernateUtil.registerInterceptor(null);
    }

    // ********************************************************** //

    public AuditTest(
        String x )
    {
        super( x );
    }

    public static void main(
        String[] args )
        throws Exception
    {
        TestRunner.run( new AuditTest( AuditTest.class.getName() ).getRuntimeSuite() );
    }

}
